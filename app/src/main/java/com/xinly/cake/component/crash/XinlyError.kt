package com.xinly.pcvd.component.crash

/**
 * Created by zm on 2019-08-20.
 */
class XinlyError(message: String?=null, cause: Throwable?=null) : Throwable(message, cause) {

   companion object{
       fun create(cause: Throwable, vararg datas: String): XinlyError{
           val result = StringBuilder()
           if(datas.isNotEmpty()){
               datas.forEach {
                   if (result.isNotEmpty()){
                       result.append("\r\n")
                   }
                   result.append(it)
               }
           }
           return if (result.isEmpty()){
               XinlyError(cause = cause)
           }else{
               XinlyError(result.toString(), cause)
           }
       }

       fun create(key: String, value: String, cause: Throwable, vararg datas: String): XinlyError {
           val result = StringBuilder()
           if(datas.isNotEmpty()){
               datas.forEach {
                   if (result.isNotEmpty()){
                       result.append("\r\n")
                   }
                   result.append(it)
               }
           }
           return XinlyError(result.toString(), cause)
       }
   }
}