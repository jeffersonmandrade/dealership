import React, { useState, useEffect } from 'react';
import './CarTable.css';

const CarTable = () => {
  const [cars, setCars] = useState([]);

  useEffect(() => {
    // Função para buscar os dados dos carros
    const fetchCars = async () => {
      try {
        const response = await fetch('http://localhost:8081/car/list');
        console.log(response);
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        const data = await response.json();
        setCars(data);
      } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
      }
    };

    fetchCars();
  }, []);

  return (
    <div>
      <h1>Car List</h1>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Brand</th>
            <th>Model</th>
            <th>Color</th>
            <th>Year</th>
            <th>Fuel Type</th>
            <th>Number of Doors</th>
            <th>Trunk Size</th>
            <th>Has Sunroof</th>
          </tr>
        </thead>
        <tbody>
          {cars.map((car) => (
            <tr key={car.id}>
              <td>{car.id}</td>
              <td>{car.brand}</td>
              <td>{car.model}</td>
              <td>{car.color}</td>
              <td>{car.year}</td>
              <td>{car.fuelType}</td>
              <td>{car.numberOfDoors}</td>
              <td>{car.trunkSize}</td>
              <td>{car.hasSunroof ? 'Yes' : 'No'}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default CarTable;
