package com.example.evc_final.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/example/evc_final/data/repository/Ec_finalRepository;", "", "ec_finalDao", "Lcom/example/evc_final/data/db/Ec_finalDao;", "(Lcom/example/evc_final/data/db/Ec_finalDao;)V", "getEc_finalDao", "()Lcom/example/evc_final/data/db/Ec_finalDao;", "addFavorite", "", "ec_final", "Lcom/example/evc_final/model/Ec_final;", "(Lcom/example/evc_final/model/Ec_final;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "borrarFavorite", "getEc_final", "Lcom/example/evc_final/data/response/ApiResponse;", "Lcom/example/evc_final/data/response/ListResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavorites", "", "app_debug"})
public final class Ec_finalRepository {
    @org.jetbrains.annotations.Nullable
    private final com.example.evc_final.data.db.Ec_finalDao ec_finalDao = null;
    
    public Ec_finalRepository() {
        super();
    }
    
    public Ec_finalRepository(@org.jetbrains.annotations.Nullable
    com.example.evc_final.data.db.Ec_finalDao ec_finalDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.example.evc_final.data.db.Ec_finalDao getEc_finalDao() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getEc_final(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evc_final.data.response.ApiResponse<com.example.evc_final.data.response.ListResponse>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object addFavorite(@org.jetbrains.annotations.NotNull
    com.example.evc_final.model.Ec_final ec_final, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object borrarFavorite(@org.jetbrains.annotations.NotNull
    com.example.evc_final.model.Ec_final ec_final, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.evc_final.model.Ec_final> getFavorites() {
        return null;
    }
}