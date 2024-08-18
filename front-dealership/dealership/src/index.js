
import React from 'react';
import ReactDOM from 'react-dom/client'; // Atualize para 'react-dom/client' no React 18
import App from './App';
import './index.css';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// Opcional: Use reportWebVitals para medir o desempenho
reportWebVitals();