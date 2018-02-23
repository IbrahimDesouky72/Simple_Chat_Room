/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author IbrahimDesouky
 */
@WebServlet(name = "signUphandling", urlPatterns = {"/signUphandling"})
public class signUphandling extends HttpServlet {
    static ArrayList<User>users=new ArrayList<>();
    static ArrayList<User>onlineUsers=new ArrayList<>();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet signUphandling</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet signUphandling at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out=response.getWriter();

        String name=request.getParameter("name");
        String pass=request.getParameter("pass");
        String res=validateUser(name, pass);
        if(res.equals("true")){
            User user=new User(name, pass);
            users.add(user);
        response.sendRedirect("login.html");
        
        }else{
            out.print("this mail already used <a href='login.html'>login</a>");
        }
        
        
    }
    private String validateUser(String name,String pass){
       
            for(int i=0;i<users.size();i++){
                if(users.get(i).getName().equals(name)){
                    return "user already exist";
                }
            }
            return "true";
        
    
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
         if(request.getParameter("page").equals("login")){
         String name=request.getParameter("name");
        String pass=request.getParameter("pass");
        boolean isExist=false;
        //String res=validateUser(name, pass);
        
        for(int i=0;i<users.size();i++){
                if(users.get(i).getName().equals(name)&&users.get(i).getPass().equals(pass)){
                    
                    User user=new User(name, pass);
                    onlineUsers.add(user);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("name",name);
                    response.sendRedirect("message.jsp");
                    isExist=true;
                    break;
                    
                    
                    
                }
            }
        if(!isExist){
            RequestDispatcher rd = request.getRequestDispatcher("login.html");
                rd.include(request, response);
                response.getOutputStream().print("invalid username or password");
        
        }
        }else{
         
              HttpSession session = request.getSession(false);
            String name = (String) session.getAttribute("name");
            for(User user : onlineUsers){
                if(user.getName().equals(name)){
                
                    onlineUsers.remove(user);
                    break;
                }
            }
            session.invalidate();
            response.sendRedirect("login.html");
            
        }
         
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
