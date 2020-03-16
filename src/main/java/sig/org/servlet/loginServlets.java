package sig.org.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import sig.org.classe.Utilisateur;
import sig.org.dao.UtilisateurRepository;
import sig.org.metier.Iutilisateur;

/**
 * Servlet implementation class loginServlets
 */
@WebServlet("/login")
public class loginServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
    private Iutilisateur utilisateurMetier;
    
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

    
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher( "/WEB-INF/login.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Optional<Utilisateur> user;
		try {
			user = utilisateurMetier.connectionUtilisateur(request.getParameter("adresse e-mail"), request.getParameter("passeword"));
			  if(user.isPresent()) {
				  response.sendRedirect ("siteEscalade.jsp?");
				  
			  }else {
				  response.sendRedirect ("login.jsp?");
			  }
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		  
	  
	
	}

}
