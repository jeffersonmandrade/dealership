import React, { useState, useEffect } from 'react';

const CarDealerships = () => {
  const [dealerships, setDealerships] = useState([]);

  useEffect(() => {
    // Fetch data from API
    fetch('http://localhost:8081/dealership/list')
      .then(response => response.json())
      .then(data => setDealerships(data))
      .catch(error => console.error('Error fetching data:', error));
  }, []);

  return (
    <div>
      {dealerships.map(dealership => (
        <div key={dealership.id}>
          <h2>{dealership.name}</h2>
          <p>Email: {dealership.email}</p>
          <p>Phone: {dealership.phone}</p>
          <p>CNPJ: {dealership.cnpj}</p>
          <table>
            <thead>
              <tr>
                <th>Brand</th>
                <th>Model</th>
                <th>Color</th>
                <th>Year</th>
                <th>Fuel Type</th>
                <th>Type/Doors</th>
                <th>Engine Size/Trunk Size</th>
                <th>Starting Method/Sunroof</th>
              </tr>
            </thead>
            <tbody>
              {dealership.automobiles.map(auto => (
                <tr key={auto.model + auto.year}>
                  <td>{auto.brand}</td>
                  <td>{auto.model}</td>
                  <td>{auto.color}</td>
                  <td>{auto.year}</td>
                  <td>{auto.fuelType}</td>
                  <td>{auto.motorcycleType || auto.numberOfDoors}</td>
                  <td>{auto.engineDisplacement || auto.trunkSize}</td>
                  <td>{auto.startType || (auto.hasSunroof ? 'Yes' : 'No')}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      ))}
    </div>
  );
};

export default CarDealerships;
