package com.ischoolbar.programmer.controller.home;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ischoolbar.programmer.entity.admin.Order;
import com.ischoolbar.programmer.entity.admin.OrderStatus;
import com.ischoolbar.programmer.service.admin.OrderService;
import com.ischoolbar.programmer.service.admin.OrderStatusService;

/**
 * ǰ̨���ſ�����
 * @author llq
 *
 */
@RequestMapping("/order")
@Controller
public class HomeOrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderStatusService orderStatusService;
	
	/**
	 * �����µ�
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/online_order")
	public ModelAndView onlineOrder(ModelAndView model){
		model.addObject("orderActive", "active");
		model.setViewName("home/order/online_order");
		return model;
	}
	
	/**
	 * ��ѯ����
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/query_order")
	public ModelAndView queryOrder(ModelAndView model,String sn){
		if(!StringUtils.isEmpty(sn)){
			Map<String, Object> queryMap = new HashMap<String, Object>();
			queryMap.put("orderSn", sn);
			List<OrderStatus> findList = orderStatusService.findList(queryMap);
			model.addObject("orderStatusList", findList);
			Order findBySn = orderService.findBySn(sn);
			String msg = "���Ķ������ύ�ɹ����ȴ�ϵͳ���䡣";
			if(findBySn == null){
				msg = "�õ��Ų����ڣ�";
			}
			model.addObject("msg", msg);
		}
		model.addObject("orderActive", "active");
		model.setViewName("home/order/query_order");
		model.addObject("sn",sn);
		return model;
	}
	
	/**
	 *�ύ������Ϣ
	 * @return
	 */
	@RequestMapping(value="/add_order",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addOrder(Order order){
		Map<String, Object> ret = new HashMap<String, Object>();
		if(order == null){
			ret.put("type", "error");
			ret.put("msg", "����д��ȷ�Ķ�����Ϣ");
			return ret;
		}
		String sn = System.currentTimeMillis()+"";
		order.setSn(sn);
		order.setCreateTime(new Date());
		int add = orderService.add(order);
		if(add < 0){
			ret.put("type", "error");
			ret.put("msg", "�����ύʧ�ܣ�����ϵ����Ա");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "add success");
		ret.put("sn", sn);
		return ret;
	}
	
	
	
}
