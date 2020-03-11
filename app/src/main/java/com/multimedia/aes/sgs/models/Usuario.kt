package com.multimedia.aes.sgs.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Usuario{
    @SerializedName("id_user")
    @Expose
    private val id_user: Int? = null


    @SerializedName("login")
    @Expose
    private val login: String? = null


    @SerializedName("pass")
    @Expose
    private val pass: String? = null


    @SerializedName("uname")
    @Expose
    private val uname: String? = null


    @SerializedName("email")
    @Expose
    private val email: String? = null


    @SerializedName("tecnico")
    @Expose
    private val tecnico: Int? = null


    @SerializedName("cod_inst_ib")
    @Expose
    private val cod_inst_ib: String? = null


    @SerializedName("fk_empresa")
    @Expose
    private val fk_empresa: Int? = null


    @SerializedName("fk_entidad")
    @Expose
    private val fk_entidad: Int? = null


    @SerializedName("fk_compania")
    @Expose
    private val fk_compania: Int? = null


    @SerializedName("fk_departamento")
    @Expose
    private val fk_departamento: Int? = null


    @SerializedName("sabados")
    @Expose
    private val sabados: Int? = null


    @SerializedName("apikey")
    @Expose
    private val apikey: Int? = null

}