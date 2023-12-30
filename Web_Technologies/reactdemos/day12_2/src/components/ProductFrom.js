import React, { useState } from "react";
import ProductService from "../service/ProductService";
export default function ProductFrom() {
  const [formdetails, setformdetails] = useState({
    pid: "",
    pname: "",
    qty: "",
    price: "",
  });
  const [formerrors, seterrors] = useState({});
  const validateForm = () => {
    let errors = {};
    if (formdetails.pid.trim().length === 0) {
      errors.piderr = "pid can't be empty!!";
    }
    if (formdetails.qty < 0) {
      errors.qtyerr = "Quantity can't be less than zero!!";
    }
    seterrors(errors);
    return errors;
  };
  
  const addproduct = () => {
    var errors = validateForm();
    if (Object.keys(errors)) {
      return;
    } else {
      ProductService.insertProduct(formdetails);
      setformdetails({ pid: "", pname: "", qty: "", price: "" });
      props.chflag();
    }
  };
  changeflag(){
    this.setState({...this.state,flag:true})
  }
  resetflag(){
    this.setState({...this.state,flag:false})
  }
  const handlechange = (event) => {
    //let name = event.target.name;
    //let value = event.target.value;
    let { name, value } = event.target;
    setformdetails({ ...formdetails, [name]: value });
  };
  return (
    <div>
      ProductFrom
      <form>
        <div class="form-group">
          <label for="pid">PID</label>
          <input
            type="text"
            class="form-control"
            id="pid"
            value={formdetails.pid}
            onChange={handlechange}
          />
          <small id="emailHelp" class="form-text text-muted">
            We'll never share your email with anyone else.
          </small>
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1">Product Name</label>
          <input
            type="text"
            class="form-control"
            value={formdetails.pname}
            id="pnameexampleInputPassword1"
            onChange={handlechange}
          />
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1">Quantity</label>
          <input
            type="number"
            class="form-control"
            value={formdetails.qty}
            id="qty"
            onChange={handlechange}
          />
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1"> Price</label>
          <input
            type="number"
            class="form-control"
            id="price"
            value={formdetails.price}
            onChange={handlechange}
          />
        </div>
        <div class="form-check">
          <input type="checkbox" class="form-check-input" id="exampleCheck1" />
          <label class="form-check-label" for="exampleCheck1">
            Check me out
          </label>
        </div>
        <button type="submit" class="btn btn-primary">
          Submit
        </button>
      </form>
    </div>
  );
}
