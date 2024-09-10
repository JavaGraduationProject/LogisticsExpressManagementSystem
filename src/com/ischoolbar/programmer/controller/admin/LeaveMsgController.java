package com.ischoolbar.programmer.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ischoolbar.programmer.entity.admin.LeaveMsg;
import com.ischoolbar.programmer.page.admin.Page;
import com.ischoolbar.programmer.service.admin.LeaveMsgService;

/**
 * ���Կ�����
 * @author llq
 *
 */
@RequestMapping("/admin/leave_msg")
@Controller
public class LeaveMsgController {
	
	@Autowired
	private LeaveMsgService leaveMsgService;
	
	/**
	 * �����б�ҳ��
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.setViewName("leave_msg/list");
		return model;
	}
	
	
	/**
	 * ������Ϣ�༭
	 * @param newsCategory
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> edit(LeaveMsg leaveMsg){
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
		if(StringUtils.isEmpty(leaveMsg.getContent())){
			ret.put("type", "error");
			ret.put("msg", "���ݲ���Ϊ�գ�");
			return ret;
		}
		if(leaveMsgService.edit(leaveMsg) <= 0){
			ret.put("type", "error");
			ret.put("msg", "�޸�ʧ�ܣ�����ϵ����Ա��");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "�޸ĳɹ���");
		return ret;
	}
	
	/**
	 * ɾ������
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> delete(String ids){
		Map<String,String> ret = new HashMap<String, String>();
		if(ids == null){
			ret.put("type", "error");
			ret.put("msg", "��ѡ��Ҫɾ������Ϣ��");
			return ret;
		}
		if(ids.contains(",")){
			ids = ids.substring(0,ids.length()-1);
		}
		if(leaveMsgService.delete(ids) <= 0){
			ret.put("type", "error");
			ret.put("msg", "ɾ��ʧ�ܣ�����ϵ����Ա��");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "ɾ���ɹ���");
		return ret;
	}
	
	/**
	 * ��ҳģ��������ѯ�б�
	 * @param name
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getList(
			@RequestParam(name="name",required=false,defaultValue="") String name,
			@RequestParam(name="content",required=false,defaultValue="") String content,
			Page page
			){
		Map<String,Object> ret = new HashMap<String, Object>();
		Map<String,Object> queryMap = new HashMap<String, Object>();
		queryMap.put("name", name);
		queryMap.put("content", content);
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		ret.put("rows", leaveMsgService.findList(queryMap));
		ret.put("total", leaveMsgService.getTotal(queryMap));
		return ret;
	}
}
