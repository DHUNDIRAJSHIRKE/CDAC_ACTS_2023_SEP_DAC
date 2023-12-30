import React from "react";
import { NavLink } from "react-router-dom";
//import AuthContextProvider from "./context/AuthContext";
export default function Navbar() {
  return (
    <div>
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">
          Navbar
        </a>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <NavLink className="nav-link" to="/form">
                Form
              </NavLink>
            </li>
            <li class="nav-item">
              <NavLink className="nav-link" to="/table">
                Table
              </NavLink>
            </li>

            <li class="nav-item">
              <NavLink className="nav-link" to="/list">
                List
              </NavLink>
            </li>
          </ul>
        </div>
      </nav>
    </div>
  );
}
