package com.application.kpti.ui.home.Epoxy

import android.util.Log
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.carousel
import java.lang.Exception


class HomeController(homeOnItemclickListener: homeOnItemclickListener) : EpoxyController(
    EpoxyAsyncUtil.getAsyncBackgroundHandler(),
    EpoxyAsyncUtil.getAsyncBackgroundHandler()
) {

    private var _currentResult: HomeProperty? = null
    private var listener = homeOnItemclickListener
    var isShowShimmers = true

    override fun buildModels() {

        headerPPopuler {
            id(0)
        }

        ShimmerContentPPopulerModel_()
            .id(8)
            .onBind { model, view, position ->
                view.binding.shimmerpp.startShimmerAnimation()
                Thread {
                    Thread.sleep(200)
                    isShowShimmers = false
                    view.binding.shimmerpp.post {
                        view.binding.shimmerpp.stopShimmerAnimation()
                        hideShimmers()
                    }
                }.start()
            }
            .addIf(isShowShimmers,this)

        // property populer
        val models = _currentResult!!.property_populer.map {

            when(it.isFavorite) {
                true -> {
                    //favorite
                    ContentPPopulerFavModel_()
                        .id(6)
                        .property_name(it.property_name)
                        .img_property(it.img_property)
                        .itemClickListener { model, parentView, clickedView, position ->
                            this@HomeController.listener.OnclickItemPropertypopuler(model.property_name()!!+model.ids())
                        }
                }
                false -> {
                    ContentPPopulerModel_()
                        .id(1)
                        .property_name(it.property_name)
                        .img_property(it.img_property)
                        .itemClickListener { model, parentView, clickedView, position ->
                            this@HomeController.listener.OnclickItemPropertypopuler(model.property_name()!!+model.ids())
                        }
                }
                }
            }

        if (!isShowShimmers) {
            carousel {
                id("coursel")
                models(models)
            }
        }

        // property terkini
        headerPTekini {
            id(2)
        }

        ShimmerContentPTerkiniModel_()
            .id(9)
            .onBind { model, view, position ->
                view.binding.shimmerPT.startShimmerAnimation()
                Thread {
                    Thread.sleep(200)
                    view.binding.shimmerPT.post {
                        view.binding.shimmerPT.stopShimmerAnimation()
                        hideShimmers()
                    }
                }.start()
            }
            .addIf(isShowShimmers,this)


        if (!isShowShimmers) {
            _currentResult!!.property_terkini.forEach{
                when(it.isFavorite){
                    true -> {
                        //favorite
                        contentPTerkiniFav {
                            id(7)
                            imgproperty(it.img_property)
                            propertyname(it.property_name)
                            location(it.location)
                            price("Rp. "+it.price)
                            itemClickListener { model, parentView, clickView, position ->
                                this@HomeController.listener.OnclickItemPropertyterkini(it.property_name+" "+it.price)
                            }
                        }
                    }

                    false -> {
                        contentPTerkini {
                            id(3)
                            imgproperty(it.img_property)
                            propertyname(it.property_name)
                            location(it.location)
                            price("Rp."+it.price)
                            itemClickListener { model, parentView, clickedView, position ->
                                this@HomeController.listener.OnclickItemPropertyterkini(model.propertyname()!!+model.price())
                            }
                        }
                    }
                }
            }
        }

        headerPSekitar {
            id(4)
        }

        ShimmerContentPSekitarModel_()
            .id(10)
            .onBind { model, view, position ->
                view.binding.shimmerPS.startShimmerAnimation()
                Thread {
                    Thread.sleep(200)
                    view.binding.shimmerPS.post {
                        view.binding.shimmerPS.stopShimmerAnimation()
                        hideShimmers()
                    }
                }.start()
            }
            .addIf(isShowShimmers,this)

        if (!isShowShimmers) {
            _currentResult!!.property_sekitar.forEach {
                contentPSekitar {
                    id(5)
                    imgProperty(it.img_property)
                    distancePoint(it.distance)
                    propertyName(it.property_name)
                    itemClickListener { model, parentView, clickediew,position ->
                        this@HomeController.listener.OnclickItemPropertysekitar(model.propertyName()!!+model.distancePoint())
                    }
                }
            }
        }
    }

    fun submit(result: HomeProperty){
        _currentResult = result
    }

    fun hideShimmers(){
        isShowShimmers = false
        requestModelBuild()
    }


    interface homeOnItemclickListener{
        fun OnclickItemPropertypopuler(nameProperty: String)
        fun OnclickItemPropertyterkini(namaProperty : String)
        fun OnclickItemPropertysekitar(namaProperty : String)
    }
}