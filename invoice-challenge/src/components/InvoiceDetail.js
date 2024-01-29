import React from 'react';

const InvoiceDetail = ({ invoice }) => {
  return (
    <div>
      <h2>Factura</h2>
      <p>Nombre del Cliente: {invoice.client}</p>
      <p>NIT: {invoice.taxId}</p>
      <p>Total: {invoice.total}</p>
    </div>
  );
};

export default InvoiceDetail;