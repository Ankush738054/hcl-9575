import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

function Login() {
  const navigate = useNavigate();
  const [empId, setEmpId] = useState();
  const [empPassword, setPassword] = useState();

  async function sendData(e) {
    try {
      e.preventDefault();
      const server = await fetch("http://localhost:8080/v1/user/login", {
        method: "Post",
        body: JSON.stringify({
          emp_id: Number(empId),
          password: empPassword,
        }),
        headers: { "Content-Type": "application/json" },
      });
      const status = await server.text();
      if (server.ok) {
        navigate("/dashboard", { state: { empId } });
      } else {
        alert(status);
      }
    } catch (e) {
      console.log(e);
    }
  }

  return (
    <div className="container-fluid min-vh-100 bg-body-tertiary d-flex align-items-center justify-content-center py-5">
      <div className="card border-0 shadow-sm rounded-4 w-100" style={{ maxWidth: "440px" }}>
        <div className="card-body p-4 p-md-5">
          <h1 className="h3 text-center mb-2">Welcome Back</h1>
          <p className="text-secondary text-center mb-4">Login with your employee credentials</p>
          <form onSubmit={sendData}>
        <div className="mb-3">
          <label htmlFor="empId" className="form-label">Employee ID</label>
          <input
            onChange={(e) => setEmpId(e.target.value)}
            type="text"
            className="form-control"
            id="empId"
            placeholder="Enter employee ID"
          />
        </div>
        <div className="mb-3">
          <label htmlFor="exampleInputPassword1" className="form-label">Password</label>
          <input
            onChange={(e) => setPassword(e.target.value)}
            type="password"
            className="form-control"
            id="exampleInputPassword1"
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
          Login
        </button>
      </form>
        </div>
      </div>
    </div>
  );
}

export default Login;
