package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Principal", urlPatterns = {"/Principal"})
public class Principal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       HttpSession ses = request.getSession();
        
        RegistroDAO gestor = (RegistroDAO) ses.getAttribute("gestor");
        
        if (gestor == null) {
            RegistroDAO aux = new RegistroDAO();
            ses.setAttribute("gestor", aux);
        }
        String op = request.getParameter("op");
        if (op == null) {
            op = "";
        }
        
        
        if (op.trim().equals("")) {
            response.sendRedirect("Vista/listado.jsp");
        }
        if (op.trim().equals("nuevo")) {
            ses = request.getSession();
            
            Registro obj = new Registro();
            
            obj.setId(gestor.getCorrelativo()+1);
            request.setAttribute("item", obj);
            request.getRequestDispatcher("Vista/nuevo.jsp").forward(request, response);
        }
        
        if (op.trim().equals("editar")) {
            
            int pos = gestor.posicion(Integer.parseInt(request.getParameter("id")));
            Registro obj = gestor.getRegistros().get(pos);
            
            request.setAttribute("item", obj);
            request.getRequestDispatcher("Vista/Vista.jsp").forward(request, response);
        }
        
        if(op.trim().equals("eliminar")){
            int pos = gestor.posicion(Integer.parseInt(request.getParameter("id")));
            gestor.getRegistros().remove(pos);
            
            request.getRequestDispatcher("Vista/listado.jsp");                 
        }

        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession ses = request.getSession();
        
        RegistroDAO gestor = (RegistroDAO) ses.getAttribute("gestor");
        Registro obj = new Registro();
        
        
        gestor.setCorrelativo(gestor.getCorrelativo()+1);
        
        obj.setId(Integer.parseInt(request.getParameter("id")));
        obj.setNombre(request.getParameter("nombre"));
        obj.setPeso(Integer.parseInt(request.getParameter("peso")));
        obj.setTalla(Integer.parseInt(request.getParameter("talla")));
        obj.setVacuna(request.getParameter("vacuna"));

        
        String tipo = request.getParameter("tipo");
        
        if (tipo.equals("-1")) {
            obj.setId(gestor.getCorrelativo());
            gestor.insertar(obj);
        } else {
            gestor.modificar(obj.getId(), obj);
        }
        response.sendRedirect("Vista/listado.jsp");
    }

    }
    

