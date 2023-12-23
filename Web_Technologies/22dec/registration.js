function valaidatename(){
    var nm=document.getElementById("nm").value;
    if(nm.trim().length<3){
       document.getElementById("errnm").innerHTML="name acannot be only spaces";
        return false;
   }
  
   document.getElementById("errnm").innerHTML=""
   return true;
}
function validateradioButton(name,err){
    var arr=document.getElementsByName(name);
  
    for(var rd of arr){
        if(rd.checked){
             document.getElementById(err).innerHTML="";
             return true;
       }
    }
   
    document.getElementById(err).innerHTML="select minimum one value"
    return false;

}
function validatehobbies(){
    var cnt=0;
    var arr=document.getElementsByName("hobbies");
    for(var hb of arr){
        if(hb.checked){
            cnt++;
           if(cnt>=2){
               document.getElementById("errhobbies").innerHTML=""
              return true;
           }
    }
  
    document.getElementById("errhobbies").innerHTML="minimum 2 hobbies should be selected"
    return false;
}
function validatecity(){
  
   if(document.getElementById("city").selectedIndex!==0){
    document.getElementById("errcity").innerHTML="";
    return true;
   }
   document.getElementById("errcity").innerHTML="pls select the city";
   return false;
}
function validatedata(){
    var flag=valaidatename();
    console.log(flag)
    var flag1=validateradioButton("gender","errgender");
    var flag2=validateradioButton("degree","errdegree");
    var flag3=validatehobbies();
    var flag4=validatecity();
    return flag && flag1 && flag2 && flag3;

}
}