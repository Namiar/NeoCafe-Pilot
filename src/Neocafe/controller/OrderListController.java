package Neocafe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;

import Neocafe.dao.MenuDAO;
import Neocafe.dao.OrderListDAO;
import Neocafe.dao.OrderMenuDAO;
import Neocafe.model.OrderList;
import Neocafe.model.OrderMenu;

/**
 * Servlet implementation class OrderListController
 */
@WebServlet("/OrderListController")
public class OrderListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderListDAO daoOrderList;
	private OrderMenuDAO daoOrderMenu;
	String forward="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderListController() {
        super();
        new MenuDAO();
        daoOrderList = new OrderListDAO();
        daoOrderMenu = new OrderMenuDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("allCustOrder")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("semuaorder", daoOrderList.getAllOrderListCust(id));
			forward="cust_order.jsp";
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
			
		} else if (action.equalsIgnoreCase("receipt")) {
			
			int orderid = Integer.parseInt(request.getParameter("orderid"));
			int id = Integer.parseInt(request.getParameter("id"));
			
			OrderList oL2 = new OrderList();
			oL2 = daoOrderList.getOrderbyOrderid(orderid);
			//Set content type to application / pdf
		    //browser will open the document only if this is set
			
		    response.setContentType("application/pdf");
		    //Get the output stream for writing PDF object        
		    OutputStream out=response.getOutputStream();
		    
		    
		    try {
		        Document document = new Document();
		        /* Basic PDF Creation inside servlet */
		        PdfWriter.getInstance(document, out);
		        document.open();
		        Paragraph paragraph = new Paragraph();
		        paragraph = new Paragraph("Neocafe");
		        paragraph.setAlignment(Element.ALIGN_CENTER);
		        document.add(paragraph);

		        paragraph = new Paragraph("Purchase Receipt");
		        paragraph.setAlignment(Element.ALIGN_CENTER);
		        document.add(paragraph);

		        DottedLineSeparator separator = new DottedLineSeparator();
		        separator.setPercentage(59500f / 523f);
		        Chunk linebreak = new Chunk(separator);
		        document.add(linebreak);

		        paragraph = new Paragraph("Order ID: "+oL2.getOrderid());
		        paragraph.setAlignment(Element.ALIGN_LEFT);
		        document.add(paragraph);

		        paragraph = new Paragraph("Order Date: "+oL2.getOrderdate());
		        paragraph.setAlignment(Element.ALIGN_LEFT);
		        document.add(paragraph);
		        
		        paragraph = new Paragraph("\n\n");
		        paragraph.setAlignment(Element.ALIGN_LEFT);
		        document.add(paragraph);
		        
		        PdfPTable table = new PdfPTable(3);

		        // t.setBorderColor(BaseColor.GRAY);
		        // t.setPadding(4);
		        // t.setSpacing(4);
		        // t.setBorderWidth(1);
		        DecimalFormat priceFormatter = new DecimalFormat("0.00");
		        
		        PdfPCell c1 = new PdfPCell(new Phrase("Menu Name"));
		        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		        table.addCell(c1);

		        c1 = new PdfPCell(new Phrase("Quantity"));
		        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		        table.addCell(c1);

		        c1 = new PdfPCell(new Phrase("Total"));
		        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		        table.addCell(c1);
		        table.setHeaderRows(1);
		        
		        List<OrderMenu> oM = daoOrderMenu.getAllOrderMenuPaid(oL2.getOrderid(),id);
		        for (int i=0; i<oM.size(); i++) {
		        	table.addCell(oM.get(i).getMenuname());
		        	table.addCell(""+oM.get(i).getQuantity());
		        	
		        	String tot = priceFormatter.format(oM.get(i).getMenuprice()*oM.get(i).getQuantity());
		        	table.addCell("RM"+tot);
		        }
		        table.addCell("");
	        	table.addCell("Total");
	        	table.addCell("RM"+priceFormatter.format(oL2.getOrdertotal()));
		        document.add(table);
		        
		        paragraph = new Paragraph("Thank You for Purchase");
		        paragraph.setAlignment(Element.ALIGN_LEFT);
		        document.add(paragraph);
		        
		        document.close();
		    }
		    catch (DocumentException exc){
		            throw new IOException(exc.getMessage());
		    }
		    finally {            
		        out.close();
		    }
		} else if (action.equalsIgnoreCase("viewordercust")) { //view list order

			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("custorderdetails", daoOrderMenu.getAllOrderMenubyCustid(id));
			request.setAttribute("cuo", daoOrderList.getAllOrderListbyCustid(id));
			
			DecimalFormat pf = new DecimalFormat("0.00");
			request.setAttribute("pf", pf);
			forward = "admin_vieworder.jsp";
			
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
			
		} else if (action.equalsIgnoreCase("listordercust")) { //tak siap lagi
			
			request.setAttribute("semuacustorder", daoOrderList.getAllOrderList());
			//request.setAttribute("getme", daoOrderMenu.getStatus());
			forward = "admin_ordercust.jsp";
			
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("custOrder")) {
			int id = Integer.parseInt(request.getParameter("id"));
			float total = Float.parseFloat(request.getParameter("total"));
			
			if (daoOrderMenu.getAllOrderMenubyStatus(id) != null) {
				daoOrderList.addOrderList(total, id); //1
				OrderList oL = daoOrderList.getOrderListbyCustid(total, id); //2
				System.out.println(oL.getOrderid());
				daoOrderMenu.updateAllOrderMenu(id, oL.getOrderid()); 
				
				DecimalFormat priceFormatter = new DecimalFormat("0.00");
				request.setAttribute("priceFormatter", priceFormatter);
				
				OrderList oL2 = new OrderList();
				oL2 = daoOrderList.getOrderPaid(id);
				
				request.setAttribute("order", oL2);

				request.setAttribute("semuaorder2", daoOrderMenu.getAllOrderMenuPaid(oL2.getOrderid(),id));
		
				
				forward = "cust_orderpaid.jsp";	
				
				RequestDispatcher view = request.getRequestDispatcher(forward);
				view.forward(request, response);
			}
		}else if (action.equalsIgnoreCase("deliverycompleted")) {
			
			int id = Integer.parseInt(request.getParameter("mid"));
			int sid = Integer.parseInt(request.getParameter("sid"));
			//set on delivery to completed
			daoOrderMenu.updateDeliveryStatus(id);
			daoOrderList.updateOrderListbyStaff(sid,id);
			request.setAttribute("semuacustorder", daoOrderList.getAllOrderList());
			forward = "admin_ordercust.jsp";
			
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
			
		}
		
	}

}
