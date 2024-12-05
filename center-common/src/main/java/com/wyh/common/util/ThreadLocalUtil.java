package com.wyh.common.util;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalUtil {

    private static final ThreadLocal<Map<String, Object>> MAP_THREAD_LOCAL = ThreadLocal.withInitial(HashMap::new);

    public static void set(String key, Object value){
        Map<String, Object> map = MAP_THREAD_LOCAL.get();
        map.put(key, value);
        MAP_THREAD_LOCAL.set(map);
    }

    public static Object get(String key){
        return MAP_THREAD_LOCAL.get().get(key);
    }

    public static Object remove(String key){
        return MAP_THREAD_LOCAL.get().remove(key);
    }

    public static void removeAll(){
        MAP_THREAD_LOCAL.remove();
    }
}
