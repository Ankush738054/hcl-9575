import React, { useState } from "react";

function Registration() {
  const [empId, setEmpId] = useState();
  const [empName, setEmpName] = useState();
  const [empDesignation, setDesignation] = useState();
  const [empStack, setStack] = useState();
  const [empEmail, setEmail] = useState();
  const [empPassword, setPassword] = useState();

  async function sendData(e) {
    try {
      e.preventDefault();
      const server = await fetch("http://localhost:8080/v1/user/addemp", {
        method: "Post",
        body: JSON.stringify({
          emp_id: Number(empId),
          emp_name: empName,
          designation: empDesignation,
          stack: empStack,
          email: empEmail,
          password: empPassword,
        }),
        headers: { "Content-Type": "application/json" },
      });
      const status = await server.text();
      alert(status);
    } catch (e) {
      console.log(e);
    }
  }

  return (
    <div>
      <form>
        <div class="form-group">
          <label for="exampleInputEmail1">Name</label>
          <input
            onChange={(e) => setEmpName(e.target.value)}
            required
            type="text"
            class="form-control"
            id="exampleInputEmail1"
            aria-describedby="emailHelp"
            placeholder="Enter Name"
          />
        </div>
        <div class="form-group">
          <label for="exampleInputEmail1">EmpID</label>
          <input
            onChange={(e) => setEmpId(e.target.value)}
            required
            type="text"
            class="form-control"
            id="exampleInputEmail1"
            aria-describedby="emailHelp"
            placeholder="Enter Emp-ID"
          />
        </div>
        <div class="form-group">
          <label for="exampleInputEmail1">Designation</label>
          <input
            onChange={(e) => setDesignation(e.target.value)}
            required
            type="text"
            class="form-control"
            id="exampleInputEmail1"
            aria-describedby="emailHelp"
            placeholder="Enter Designation"
          />
        </div>
        <div class="form-group">
          <label for="exampleInputEmail1">Stack</label>
          <input
            onChange={(e) => setStack(e.target.value)}
            required
            type="text"
            class="form-control"
            id="exampleInputEmail1"
            aria-describedby="emailHelp"
            placeholder="Enter Stack"
          />
        </div>
        <div class="form-group">
          <label for="exampleInputEmail1">Email</label>
          <input
            onChange={(e) => setEmail(e.target.value)}
            required
            type="email"
            class="form-control"
            id="exampleInputEmail1"
            aria-describedby="emailHelp"
            placeholder="Enter Email"
          />
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1">Password</label>
          <input
            onChange={(e) => setPassword(e.target.value)}
            required
            type="password"
            class="form-control"
            id="exampleInputPassword1"
            placeholder="Password"
          />
        </div>
        <div class="form-check">
          <input type="checkbox" class="form-check-input" id="exampleCheck1" />
          <label class="form-check-label" for="exampleCheck1">
            Check me out
          </label>
        </div>
        <button type="submit" onClick={sendData} class="btn btn-primary">
          Register
        </button>
      </form>
    </div>
  );
}

export default Registration;
