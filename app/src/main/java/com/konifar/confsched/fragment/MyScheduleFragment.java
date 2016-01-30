package com.konifar.confsched.fragment;

import com.konifar.confsched.model.Session;

import java.util.List;

import rx.Observable;

public class MyScheduleFragment extends SessionsFragment {

    public static MyScheduleFragment newInstance() {
        return new MyScheduleFragment();
    }

    @Override
    protected void loadData() {
        Observable<List<Session>> cachedSessions = dao.findByChecked();
        if (cachedSessions.isEmpty().toBlocking().single()) {
            // TODO
        } else {
            groupByDateSessions(cachedSessions.toBlocking().single());
        }
    }

}
