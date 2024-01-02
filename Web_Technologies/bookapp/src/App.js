import logo from "./logo.svg";
import "./App.css";
import Header from "./components/Header";
import Footer from "./components/Footer";
import Navbar from "./components/Navbar";
import "bootstrap/dist/css/bootstrap.css";
import { Route, Routes } from "react-router-dom";
import BookTable from "./pages/BookTable";
import BookForm from "./pages/BookForm";
import BookList from "./pages/BookList";
import BookView from "./pages/BookView";
import BookDelete from "./pages/BookDelete";
import BookUpdate from "./pages/BookUpdate";
function App() {
  return (
    <div className="App">
      <Header>Book App</Header>
      <Navbar></Navbar>
      <Routes>
        <Route path="/table" element={<BookTable></BookTable>}></Route>
        <Route path="/list" element={<BookList></BookList>}></Route>
        <Route path="/form" element={<BookForm></BookForm>}></Route>
        <Route path="/view/:id" element={<BookView></BookView>}></Route>
        <Route path="/update/:id" element={<BookUpdate></BookUpdate>}></Route>
        <Route path="/delete/:id" element={<BookDelete></BookDelete>}></Route>
      </Routes>
      <Footer></Footer>
    </div>
  );
}

export default App;
