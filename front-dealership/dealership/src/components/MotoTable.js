import React, { useState, useEffect } from 'react';
import './MotorcycleTable.css';

const MotorcycleTable = () => {
  const [motorcycles, setMotorcycles] = useState([]);

  useEffect(() => {
    // Função para buscar os dados das motocicletas
    const fetchMotorcycles = async () => {
      try {
        const response = await fetch('http://localhost:8081/motorcycle/list');
        console.log(response);
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        const data = await response.json();
        setMotorcycles(data);
      } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
      }
    };

    fetchMotorcycles();
  }, []);

  return (
    <div>
      <h1>Motorcycle List</h1>
      <table>
  <thead>
    <tr>
      <th>ID</th>
      <th>Brand</th>
      <th>Model</th>
      <th>Color</th>
      <th>Year</th>
      <th>Fuel Type</th>
      <th>Type</th>
      <th>Engine Size</th>
      <th>Starting Method</th>
    </tr>
  </thead>
  <tbody>
    {motorcycles.map((motorcycle) => (
      <tr key={motorcycle.id}>
        <td>{motorcycle.id}</td>
        <td>{motorcycle.brand}</td>
        <td>{motorcycle.model}</td>
        <td>{motorcycle.color}</td>
        <td>{motorcycle.year}</td>
        <td>{motorcycle.fuelType}</td>
        <td>{motorcycle.motorcycleType}</td>
        <td>{motorcycle.engineDisplacement}</td>
        <td>{motorcycle.startType}</td>
      </tr>
    ))}
  </tbody>
</table>

    </div>
  );
};

export default MotorcycleTable;
