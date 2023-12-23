var promise5 = fetch("https://jsonplaceholder.typicode.com/posts")
.then(result)=>{
    console.log(result);
    if(result.status===200 && result.ok){
        console.log("successful completion of AJAX request");
        return result.json();
    }
    throw "promise rejected via then function";

},(err)=>{
    console.log("eorror occured",err);
})
.catch()=>{

});