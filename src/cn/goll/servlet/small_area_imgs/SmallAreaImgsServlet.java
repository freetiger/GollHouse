package cn.goll.servlet.small_area_imgs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.goll.entity.Small_Area_Imgs;
import cn.goll.entity.Small_Areas;
import cn.goll.service.ISmall_Area_ImgsService;
import cn.goll.service.ISmall_AreasService;
import cn.goll.service.impl.Small_Area_ImgsServiceImpl;
import cn.goll.service.impl.Small_AreasServiceImpl;
@SuppressWarnings("serial")
public class SmallAreaImgsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String method=request.getParameter("method");
		 if(method.equals("query"))Query(request,response,-1,null);
		 if(method.equals("check"))Check(request,response);
		 if(method.equals("remove"))Remove(request,response);
	}

	public void Query(HttpServletRequest request, HttpServletResponse response,int result,String sa_id)
			throws ServletException, IOException {
		if(sa_id==null)
			sa_id=request.getParameter("sa_id");
		ISmall_AreasService smallAreasService=new Small_AreasServiceImpl();
		ISmall_Area_ImgsService smallAreaImgService=new Small_Area_ImgsServiceImpl();
		Small_Areas smallArea=smallAreasService.querySmall_AreasById(Integer.valueOf(sa_id), null);
		String[] ids=smallArea.getSai_ids().split(",");
		int[] sai_ids=new int[ids.length];
		for (int i = 0; i < ids.length; i++) {
			sai_ids[i]=Integer.valueOf(ids[i]);
		}
		List<Small_Area_Imgs> smallAreaImgs=new ArrayList<Small_Area_Imgs>();
		Small_Area_Imgs smallAreaImg;
		for (int i = 0; i < sai_ids.length; i++) {
			smallAreaImg=smallAreaImgService.querySmall_Area_ImgsById(sai_ids[i], null);
			smallAreaImgs.add(smallAreaImg);
		}
		request.setAttribute("smallAreaImgs", smallAreaImgs);
		request.setAttribute("sa_id", smallArea.getSa_id());
		request.getRequestDispatcher("backstage/smallArea/web_page/smallAreaImgs.jsp?result="+result).forward(request, response);
	}
	public void Check(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sai_id=request.getParameter("sai_id");
		String sa_id=request.getParameter("sa_id");
		ISmall_Area_ImgsService smallAreaImgService=new Small_Area_ImgsServiceImpl();
		Small_Area_Imgs smallAreaImg=smallAreaImgService.querySmall_Area_ImgsById(Integer.valueOf(sai_id), null);
		smallAreaImg.setSai_ischeck("1");
		int result=smallAreaImgService.updateSmall_Area_Imgs(smallAreaImg);
		Query(request,response,result,sa_id);
	}
	public void Remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sai_id=request.getParameter("sai_id");
		String sa_id=request.getParameter("sa_id");
		ISmall_AreasService smallAreasService=new Small_AreasServiceImpl();
		ISmall_Area_ImgsService smallAreaImgService=new Small_Area_ImgsServiceImpl();
		Small_Areas smallArea=smallAreasService.querySmall_AreasById(Integer.valueOf(sa_id), null);
		String[] ids=smallArea.getSai_ids().split(",");
		String sai_ids="";
		for (int i = 0; i < ids.length; i++) {
			if(!ids[i].equals(sai_id))
				sai_ids+=ids[i]+",";
		}
		smallArea.setSai_ids(sai_ids);
		smallAreasService.updateSmall_Areas(smallArea);
		int result=smallAreaImgService.deleteSmall_Area_Imgs(Integer.valueOf(sai_id));
		Query(request,response,result,sa_id);
	}
}
