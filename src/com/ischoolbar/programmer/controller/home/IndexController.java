package com.ischoolbar.programmer.controller.home;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ischoolbar.programmer.entity.admin.LeaveMsg;
import com.ischoolbar.programmer.entity.admin.News;
import com.ischoolbar.programmer.service.admin.LeaveMsgService;
import com.ischoolbar.programmer.service.admin.NewsCategoryService;
import com.ischoolbar.programmer.service.admin.NewsService;

/**
 * ǰ̨ҳ����ҳ������
 * @author llq
 *
 */
@RequestMapping("/index")
@Controller
public class IndexController {
	
	@Autowired
	private NewsCategoryService newsCategoryService;
	
	@Autowired
	private NewsService newsService;
	@Autowired
	private LeaveMsgService leaveMsgService;
	
	/**
	 * ϵͳ��ҳ
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView index(ModelAndView model){
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("offset", 0);
		queryMap.put("pageSize", 7);
		model.addObject("newsList", newsService.findList(queryMap));
		model.addObject("indexActive", "active");
		model.setViewName("home/index/index");
		return model;
	}
	
	/**
	 * ��������
	 * @return
	 */
	@RequestMapping(value="/about_us")
	public ModelAndView aboutUs(ModelAndView model){
		model.addObject("aboutusActive", "active");
		model.setViewName("home/index/about_us");
		return model;
	}
	
	
	/**
	 * ҵ��Χ
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/buss")
	public ModelAndView buss(ModelAndView model){
		model.addObject("bussActive", "active");
		model.setViewName("home/index/buss");
		return model;
	}
	
	/**
	 * �����б�
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/news_list")
	public ModelAndView newsList(ModelAndView model){
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("categoryId", 5);
		model.addObject("newsActive", "active");
		model.addObject("newsList", newsService.findList(queryMap));
		model.setViewName("home/index/news_list");
		return model;
	}
	
	/**
	 * �鿴��������
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/news_detail",method=RequestMethod.GET)
	public ModelAndView detail(ModelAndView model,Long id){
		News news = newsService.find(id);
		model.addObject("news", news);
		model.addObject("newsActive", "active");
		model.setViewName("home/index/news_detail");
		//�鿴����1
		newsService.updateViewNumber(id);
		return model;
	}
	
	/**
	 * ��ϵ����
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/contact_us")
	public ModelAndView contactUs(ModelAndView model){
		model.addObject("contactusActive", "active");
		model.setViewName("home/index/contact_us");
		return model;
	}
	
	/**
	 * ��˾����
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/honor")
	public ModelAndView honor(ModelAndView model){
		model.addObject("aboutusActive", "active");
		model.setViewName("home/index/honor");
		return model;
	}
	
	/**
	 * ��������
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/buss1")
	public ModelAndView buss1(ModelAndView model){
		model.addObject("bussActive", "active");
		model.setViewName("home/index/buss1");
		return model;
	}
	
	/**
	 * ��ʱ����
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/buss2")
	public ModelAndView buss2(ModelAndView model){
		model.addObject("bussActive", "active");
		model.setViewName("home/index/buss2");
		return model;
	}
	
	/**
	 * ��������
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/buss3")
	public ModelAndView buss3(ModelAndView model){
		model.addObject("bussActive", "active");
		model.setViewName("home/index/buss3");
		return model;
	}
	
	
	/**
	 * �Ǽʿ���
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/buss4")
	public ModelAndView buss4(ModelAndView model){
		model.addObject("bussActive", "active");
		model.setViewName("home/index/buss4");
		return model;
	}
	
	/**
	 * ������Ӯ
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/buss5")
	public ModelAndView buss5(ModelAndView model){
		model.addObject("bussActive", "active");
		model.setViewName("home/index/buss5");
		return model;
	}
	
	/**
	 * ��������
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/problem")
	public ModelAndView problem(ModelAndView model){
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("categoryId", 10);
		model.addObject("newsActive", "active");
		model.addObject("newsList", newsService.findList(queryMap));
		model.setViewName("home/index/problem");
		return model;
	}
	
	/**
	 * �������
	 * @param newsCategory
	 * @return
	 */
	@RequestMapping(value="/add_leave_msg",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> add(LeaveMsg leaveMsg){
		Map<String,String> ret = new HashMap<String, String>();
		if(leaveMsg == null){
			ret.put("type", "error");
			ret.put("msg", "����д��ȷ����Ϣ��");
			return ret;
		}
		if(StringUtils.isEmpty(leaveMsg.getName())){
			ret.put("type", "error");
			ret.put("msg", "��������Ϊ�գ�");
			return ret;
		}
		if(StringUtils.isEmpty(leaveMsg.getTel())){
			ret.put("type", "error");
			ret.put("msg", "��ϵ�绰����Ϊ�գ�");
			return ret;
		}
		if(StringUtils.isEmpty(leaveMsg.getContent())){
			ret.put("type", "error");
			ret.put("msg", "���ݲ���Ϊ�գ�");
			return ret;
		}
		leaveMsg.setCreateTime(new Date());
		if(leaveMsgService.add(leaveMsg) <= 0){
			ret.put("type", "error");
			ret.put("msg", "���ʧ�ܣ�����ϵ����Ա��");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "��ӳɹ���");
		return ret;
	}
	
}
