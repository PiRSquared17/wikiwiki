package code.lucamarrocco.wikiwikiapp;

import static code.lucamarrocco.wiki.engine.Wiki.*;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class WikiWikiServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest fromRequest, HttpServletResponse toResponse) throws ServletException, IOException {
		String wiki = readWiki(fromRequest);
		String html = wiki(wiki);
		write(html, toResponse);
	}

	private void write(String html, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		resp.getWriter().print(html);
		resp.getWriter().flush();
	}

	private String readWiki(HttpServletRequest req) {
		return req.getParameter("wiki");
	}
}