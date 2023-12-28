import logo from "./logo.svg";
import "./App.css";
import "../src/bootstrap-5.0.2-dist/css/bootstrap.min.css";
//import "bootstrap/dist/css/bootstrap.min.css";
import hill from "./images/hill.jpg";
import Header from "./components/Header";
import Footer from "./components/Footer";
import CounterClassComponent from "./components/CounterClassComponent";
import CounterfucntionalComponent from "./components/CounterfunctionalComponent";
import DisplayNames from "./components/DisplayNames";
function App() {
  let namearr = ["Revati", "Atharva", "Sohuum", "Rajashree"];
  return (
    <div>
      <h1 className="myclass">Name Lists</h1>
      <Header></Header>
      <img src={hill} width={"750px"} height={"400px"}></img>
      {/* <NameTab></NameTab> */}
      <Footer></Footer>
    </div>
  );
}

export default App;
