package com.example.hefen.jsonactorsmvp;

import com.example.hefen.jsonactorsmvp.model.Actor;

import java.util.List;

/**
 * Created by hefen on 5/4/2018.
 */

public class Presenter implements IPresenter{
    IView iView;
    IModel iModel;

    Presenter (IView iView) {
        this.iView = iView;
    }
    @Override
    public void sendCall() {
        iModel = new Model(Presenter.this);
        iModel.sendCall();
    }

    @Override
    public void setData(List<Actor> actorList) {
        iView.setData(actorList);
    }
}
