import logo from "./logo.svg";
import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./components/Home/Home";
import User from "./components/User/User";
import Navbar from "./components/Navbar/Navbar";
import Post from "./components/Post/Post";

function App() {
  return (
    <div className="App">
      
      <BrowserRouter>
      <Navbar></Navbar>
        <Routes>
          <Route exact path="/" element={<Home />}></Route>
          <Route exact path="/users/:userId" element={<User />}></Route>
          <Route exact path="/posts" element={<Post/>}>Posts</Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
