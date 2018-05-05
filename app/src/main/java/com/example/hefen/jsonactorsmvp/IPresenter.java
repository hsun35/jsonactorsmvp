package com.example.hefen.jsonactorsmvp;

import com.example.hefen.jsonactorsmvp.model.Actor;

import java.util.List;

/**
 * Created by hefen on 5/4/2018.
 */

public interface IPresenter {
    void sendCall();
    void setData(List<Actor> actorList);
}
