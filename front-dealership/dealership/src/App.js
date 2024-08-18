import './App.css';
import CarTable from './components/CarTable';
import Moto from './components/MotoTable';
import DealershipCars from './components/DealershipCars'

function App() {
  return (
    <div className="App">
      <div>
        <CarTable />
      </div>
      <div>
        <Moto />
      </div>
      <div>
      <h1>Car Dealerships</h1>
        <DealershipCars />
      </div>
    </div>
  );
}


export default App;
