package core.mvc;

import java.util.HashMap;
import java.util.Map;

import next.web.qna.ListController;
import next.web.qna.ShowController;
import next.web.user.CreateController;
import next.web.user.LoginController;
import next.web.user.LogoutController;
import next.web.user.UpdateController;
import next.web.user.UpdateFormController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestMapping {
	private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
	private Map<String, Controller> mappings = new HashMap<String, Controller>();
	
	public void initMapping() {
	    mappings.put("/user/form.next", new ForwardController("/user/form.jsp"));
	    mappings.put("/user/loginForm.next", new ForwardController("/user/login.jsp"));
	    mappings.put("/user/login.next", new LoginController());
	    mappings.put("/user/logout.next", new LogoutController());
	    mappings.put("/user/create.next", new CreateController());
	    mappings.put("/user/updateForm.next", new UpdateFormController());
	    mappings.put("/user/update.next", new UpdateController());
	    
		mappings.put("/qna/list.next", new ListController());
		mappings.put("/qna/show.next", new ShowController());
		mappings.put("/qna/form.next", new ForwardController("/qna/form.jsp"));
		
		
		logger.info("Initialized Request Mapping!");
	}

	public Controller findController(String url) {
		return mappings.get(url);
	}

	void put(String url, Controller controller) {
		mappings.put(url, controller);
	}

}