import { useState } from "react";

function Registration() {
  const [empId, setEmpId] = useState("");
  const [empName, setEmpName] = useState("");
  const [empDesignation, setDesignation] = useState("");
  const [empStack, setStack] = useState("");
  const [empEmail, setEmail] = useState("");
  const [empPassword, setPassword] = useState("");

  async function sendData(e) {
    e.preventDefault();
    try {
      const server = await fetch("http://localhost:8080/v1/user/addemp", {
        method: "POST",
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
      if (!server.ok) {
        alert(status || "Registration failed");
        return;
      }
      alert(status);
    } catch (error) {
      console.error("Registration request failed:", error);
      alert("Unable to connect to the registration service. Please try again.");
    }
  }

  return (
    <div className="container-fluid min-vh-100 bg-body-tertiary d-flex align-items-center justify-content-center py-5">
      <div className="card border-0 shadow-sm rounded-4 w-100" style={{ maxWidth: "680px" }}>
        <div className="card-body p-4 p-md-5">
          <h1 className="h3 text-center mb-2">Create Your Account</h1>
          <p className="text-secondary text-center mb-4">Enter your employee details to register</p>
          <form onSubmit={sendData}>
        <div className="mb-3">
          <label htmlFor="empName" className="form-label">Name</label>
          <input
            onChange={(e) => setEmpName(e.target.value)}
            required
            type="text"
            className="form-control"
            id="empName"
            placeholder="Enter Name"
          />
        </div>
        <div className="mb-3">
          <label htmlFor="empId" className="form-label">EmpID</label>
          <input
            onChange={(e) => setEmpId(e.target.value)}
            required
            type="number"
            min="1"
            step="1"
            className="form-control"
            id="empId"
            placeholder="Enter Emp-ID"
          />
        </div>
        <div className="mb-3">
          <label htmlFor="empDesignation" className="form-label">Designation</label>
          <input
            onChange={(e) => setDesignation(e.target.value)}
            required
            type="text"
            className="form-control"
            id="empDesignation"
            placeholder="Enter Designation"
          />
        </div>
        <div className="mb-3">
          <label htmlFor="empStack" className="form-label">Stack</label>
          <input
            onChange={(e) => setStack(e.target.value)}
            required
            type="text"
            className="form-control"
            id="empStack"
            placeholder="Enter Stack"
          />
        </div>
        <div className="mb-3">
          <label htmlFor="empEmail" className="form-label">Email</label>
          <input
            onChange={(e) => setEmail(e.target.value)}
            required
            type="email"
            className="form-control"
            id="empEmail"
            placeholder="Enter Email"
          />
        </div>
        <div className="mb-3">
          <label htmlFor="empPassword" className="form-label">Password</label>
          <input
            onChange={(e) => setPassword(e.target.value)}
            required
            type="password"
            className="form-control"
            id="empPassword"
            placeholder="Password"
          />
        </div>
        <div className="form-check mb-4">
          <input type="checkbox" className="form-check-input" id="exampleCheck1" />
          <label className="form-check-label" htmlFor="exampleCheck1">
            Check me out
          </label>
        </div>
        <button type="submit" className="btn btn-primary w-100 py-2">
          Register
        </button>
      </form>
        </div>
      </div>
    </div>
  );
}

export default Registration;
