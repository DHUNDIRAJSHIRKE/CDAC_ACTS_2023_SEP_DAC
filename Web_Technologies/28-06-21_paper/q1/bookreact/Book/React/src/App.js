import logo from './logo.svg';
import './App.css';
import { Route, Routes } from 'react-router-dom';
import BookDiv from './components/BookDiv';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path='/' element={<BookDiv></BookDiv>}></Route>
      </Routes>
    </div>
  );
}

export default App;
