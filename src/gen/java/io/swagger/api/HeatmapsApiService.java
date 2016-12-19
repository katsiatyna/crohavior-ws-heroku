package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;


import io.swagger.model.HeatmapGridCollection;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2016-12-06T21:50:39.597Z")
public abstract class HeatmapsApiService {
      public abstract Response getHeatmapsByParameters(Integer projectId, Long startTime, Long endTime, Integer interval,
                                                       Long pageNmb,
                                                       String apiKey, UriInfo uri)
              throws NotFoundException;
}