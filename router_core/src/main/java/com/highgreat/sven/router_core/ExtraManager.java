package com.highgreat.sven.router_core;

import android.app.Activity;
import android.util.LruCache;

import com.highgreat.sven.router_core.template.IExtra;

public class ExtraManager {

    private static ExtraManager instance;
    private LruCache<String, IExtra> classCache;
    public static final String SUFFIX_AUTOWIRED = "$$Extra";

    public static ExtraManager getInstance() {
        if (instance == null) {
            synchronized (HGRouter.class) {
                if (instance == null) {
                    instance = new ExtraManager();
                }
            }
        }
        return instance;
    }

    public ExtraManager() {
        classCache = new LruCache<>(66);
    }

    /**
     * 注入
     *
     * @param instance
     */
    public void loadExtras(Activity instance) {
        //查找对应activity的缓存
        String className = instance.getClass().getName();
        IExtra iExtra = classCache.get(className);
        try{
            if(null == iExtra){
                iExtra = (IExtra) Class.forName(instance.getClass().getName()+SUFFIX_AUTOWIRED).getConstructor().newInstance();
            }
            iExtra.loadExtra(instance);
            classCache.put(className,iExtra);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
