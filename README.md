#### 1. Tomcat 서버를 시작할 때 웹 애플리케이션이 초기화하는 과정을 설명하라.
* 

#### 2. Tomcat 서버를 시작한 후 http://localhost:8080으로 접근시 호출 순서 및 흐름을 설명하라.
*    Tomcat tomcat = new Tomcat();
     tomcat.setPort(8080);
   에 의해 WebServerLauncher.java로 이동한다
     String webappDirLocation = "webapp/";
     tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
   에 의해 'webapp/'디렉토리롤 이동하고 tomcat server의 default설정에 의해 설정된 URL이 없으므로 index.jsp로 이동한다.
     response.sendRedirect("/qna/list.next");
 에 의해 url값 '/qna/list.next'이 redirect되어 서버로 전송된다. .next로 끝나므로 DispatcherServlet으로 이동하고
  DispatcherServlet내의 
  rm = new RequestMapping();
  에 의해 RequestMapping 으로 이동,
  RequestMapping내의
   mappings.put("/qna/list.next", new ListController());
  에 의해 ListController로 이동한다. ListController내의 execute내의
  questions = questionDao.findAll();
  에의해 QuestionDao에 저장된 질문을 모두 받아와
  		ModelAndView mav = jstlView("/qna/list.jsp");
		mav.addObject("questions", questions);
		return mav; 
>>/qna/list.jsp에 뿌린다.
