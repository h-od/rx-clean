package com.hod.device

import com.hod.domain.DataProvider
import com.hod.domain.entity.Notification
import io.reactivex.Observable

class Notifications: DataProvider<Notification> {
    override fun put(data: Notification) {
        TODO("not implemented")
    }

    override fun fetch(): Observable<Notification> {
        TODO("not implemented")
    }

    override fun delete(data: Notification) {
        TODO("not implemented")
    }
}
