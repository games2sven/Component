package com.highgreat.sven.router_core.template;

import com.highgreat.sven.router_annotation.model.RouteMeta;

import java.util.Map;

public interface IRouteGroup {

    void loadInto(Map<String, RouteMeta> atlas);
}
