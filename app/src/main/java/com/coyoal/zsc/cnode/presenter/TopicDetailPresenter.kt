package com.coyoal.zsc.cnode.presenter

import com.coyoal.zsc.cnode.contract.TopicDetailContract
import com.coyoal.zsc.cnode.entity.Topic
import com.coyoal.zsc.cnode.http.SimpleObserver
import com.coyoal.zsc.cnode.model.TopicDetailModel
import com.orhanobut.logger.Logger

/**
 *
 * Created by Administrator on 2017/11/17.
 */
class TopicDetailPresenter: TopicDetailContract.Presenter<TopicDetailContract.View>() {

    private val mModel = TopicDetailModel()
    private lateinit var mTopic: Topic

    override fun loadTopic(topicId: String) {
        mModel.getTopic(topicId, object: SimpleObserver<Topic>() {
            override fun onSuccess(data: Topic) {
                mTopic = data
                getView()?.setTopic(data)
            }
            override fun onFailure(errMsg: String) {
                Logger.e(errMsg)
            }
        })
    }

    override fun toComments() {
        getView()?.toComments(mTopic)
    }
}