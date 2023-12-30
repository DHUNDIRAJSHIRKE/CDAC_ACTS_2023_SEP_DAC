import React from "react";
import "./Footer.css";
export default function Footer() {
  return (
    <div>
      <h4 className="myfoot">
        &copy; 2023-{new Date().getFullYear()} Dhundiraj Shirke. All Rights
        Reserved.
      </h4>
    </div>
  );
}
