import React from "react";
const NameTab = (props) => {
  return (
    <div>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
          </tr>
        </thead>
        <tbody>
          {props.nmarr.map((ob, index) => (
            <tr>
              <td>(index+1)</td>
              <td>{ob}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
