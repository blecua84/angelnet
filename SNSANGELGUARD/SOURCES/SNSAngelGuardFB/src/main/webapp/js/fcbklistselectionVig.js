/*
 fcbkListSelection 1.10
 - Jquery version required: 1.2.x, 1.3.x, 1.4.x

 Changelog:
 - 1.1: added preselected items
 - 1.0: project started
 */
/* Coded by: emposha <admin@emposha.com> */
/* Copyright: Emposha.com <http://www.emposha.com/> - Distributed under MIT - Keep this message! */
/*
 * elem - ul element id or object
 * width - width of ul
 * height - height of each element
 * row - number of items in row
 */
$.fcbkListSelection=function(d,h,j,k,title1,title2,title3){

    //get content of tabs
    var l=function(b,c){
        switch(c){
            case "all":
                b.children("li").show();
                break;
            case "selected":
                b.children("li:not([addedid])").hide();
                b.children("li[addedid]").show();
                break;
            case "unselected":
                b.children("li[addedid]").hide();
                b.children("li:not([addedid])").show();
                break
        }
    },

    n=function(){
        switch(m()){
            case "all":
                d.children("li").show();
                break;
            case "selected":
                d.children("li:not([addedid])").hide();
                d.children("li[addedid]").show();
                break;
            case "unselected":
                d.children("li[addedid]").hide();
                d.children("li:not([addedid])").show();
                break
        }
    },

    //add to selected items function
    i=function(obj){
        if(obj.hasClass("itemselected")){
            $("#view_selected_count").text(parseInt($("#view_selected_count").text(),10)-1);
            borrarItemVigilants(obj.find("[type=hidden]").val());
            obj.parents("li").removeAttr("addedid");
            //o(obj)
        }else{
            $("#view_selected_count").text(parseInt($("#view_selected_count").text(),10)+1);
            obj.parents("li").attr("addedid","tester");
            p(obj)
        }
        n(obj);
        habilitarGuardar();
    },

    p=function(b){
        var lstAngeles = $("#hdAngelsAux");
        var a=b.find("[type=hidden]").val();
        lstAngeles.attr("value", lstAngeles.val() + a +";");
        return lstAngeles;
    },

    o=function(object){
        var lstAngeles = $("#hdAngelsAux").val();
        var lstAux = null;
        var angel = object.find("[type=hidden]").val();
        var strAngels = '';
        var angels = lstAngeles.split(';');

        // Buscamos el angel que se quiere deseleccionar
        for(var i=0;i<angels.length;i++){
            strAngels = angels[i].toString();
            if(strAngels == angel) {
                angels[i] = '';
                break;
            }
        }

        // Volvemos a conformar la lista de angeles
        for(var j=0;j<angels.length;j++){
            if(angels[j] != ''){
                lstAux = lstAux + angels[j] + ";";
            }
        }

        // Asignamos a la variable de salida la lista de angeles seleccionados
        $('#hdAngelsAux').attr("value", lstAux);
    },

    s=function(b,c){
        var a="{";
        $.each(b,function(f,g){
            if(f)a+='"'+f+'":"'+g+'",'
        });
        try{
            eval("json = "+c+";");
            $.each(c,function(f,g){
                if(f&&g)a+='"'+f+'":"'+g+'",'
            })
        }catch(e){}
        a=a.substr(0,a.length-1);
        a+="}";
        return a
    },

    r=function(b){
        try{
            eval("this."+b+" = value;")
        }catch(c){}
    },

    q=function(){
        for(var b="",c=0;c<32;c++){
            var a=Math.floor(Math.random()*61);
            b+="0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz".substring(a,a+1)
        }
        return b
    },

    m=function(){
        return $(".view_on").attr("id").replace("view_","")
    };

    if(typeof d!="object")d= $(d);
    d.css("width",h+"px");
    (function(b,c){
        c='<div id="filters" style="width:'+(parseInt(c,10)+2)+'px;"><ul class="selections" id="selections"><li id="view_all" class="view_on"><a onclick="return false;" href="#">' + title1 + '</a></li><li id="view_selected" class=""><a onclick="return false;" href="#">' + title2 + ' (<strong id="view_selected_count">0</strong>)</a></li></ul><div class="clearer"></div></div>';
        b.before(c)
    })(d, h);
    (function(b,c,a,e){
        b.children("li").wrapInner('<div class="fcbklist_item"></div>');
        $(".fcbklist_item").css("height",a+"px");
        b=Math.ceil(parseInt(c,10)/parseInt(e,10) - 20);
        $(".fcbklist_item").css("width",b+"px")
    })(d,h,j,k);
    (function(b){
        $.each($("#selections li"),function(c,a){
            a=$(a);
            a.click(function(){
                $(".view_on").removeClass("view_on");
                a.addClass("view_on");
                l(b,a.attr("id").replace("view_",""))
            })
        })
    })(d);
    (function(b){
        $.each(b.children("li").children(".fcbklist_item"),function(c,a){
            a=$(a);
            if(a.children("input[checked]").length!= 0){
                i(a);
                a.toggleClass("itemselected");
                a.parents("li").toggleClass("liselected")
            }
            a.click(function(){
                i(a);
                a.toggleClass("itemselected");
                a.parents("li").toggleClass("liselected");
            });
            a.mouseover(function(){
                a.addClass("itemover")
            });
            a.mouseout(function(){
                $(".itemover").removeClass("itemover")
            })
        })
    })(d)
};