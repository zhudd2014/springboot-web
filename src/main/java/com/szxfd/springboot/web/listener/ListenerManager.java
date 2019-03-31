///**
// * Copyright (C), 2015-2019, XXX有限公司
// * FileName: ListenerManager
// * Author:   admin
// * Date:     2019/3/31 18:19
// * Description: 监听器管理器
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.szxfd.springboot.web.listener;
//
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈监听器管理器〉
// *
// * @author admin
// * @create 2019/3/31
// * @since 1.0.0
// */
//@Component
//public class ListenerManager {
//
//    private Map<String, List<Listener>> listenersMap = new HashMap<>();
//    private static ListenerManager instance;
//
//    private ListenerManager() {
//    }
//
////    public static ListenerManager getInstance() {
////        if (null == instance) {
////            synchronized (ListenerManager.class) {
////                if (null == instance) {
////                    instance = new ListenerManager();
////                }
////            }
////        }
////        return instance;
////    }
//
//    public void registerListener(String action, Listener listener) {
//        List<Listener> listeners = listenersMap.get(action);
//        if (null == listeners) {
//            listeners = new ArrayList<>();
//        }
//        listeners.add(listener);
//    }
//
//    public void unregisterListener(String action, Listener listener) {
//        List<Listener> listeners = listenersMap.get(action);
//        if (null == listeners) {
//            return;
//        }
//        listeners.remove(listener);
//    }
//
//    /**
//     * 触发指定动作的监听器
//     *
//     * @param action
//     */
//    public void notity(String action) {
//        List<Listener> listeners = listenersMap.get(action);
//        for (Listener listener : listeners) {
//            listener.onNitify();
//        }
//    }
//}