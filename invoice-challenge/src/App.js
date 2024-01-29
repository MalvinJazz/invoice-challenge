import React, { useState, useEffect } from 'react';
import InputForm from './components/InputForm';
import InvoiceList from './components/InvoiceList';
import InvoiceEdit from './components/InvoiceEdit';

function App() {
  const [invoices, setInvoices] = useState([]);
  const [details, setDetails] = useState([]); 
  const [selectedInvoice, setSelectedInvoice] = useState(null);
  const apiUrl = 'http://localhost:8080'
  const service = `${apiUrl}/invoices/v1`

  const [show, setShow] = useState(false);
  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  useEffect(() => {
    fetchInvoices();
  }, []);

  const fetchInvoices = async () => {
    try {
      const response = await fetch(`${service}/invoice`);
      const data = await response.json();
      setInvoices(data);
    } catch (error) {
      console.error('Error fetching invoices:', error);
    }
  };

  const addInvoice = async (invoiceData) => {
    try {
      const response = await fetch(`${service}/invoice`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(invoiceData),
      });
      fetchInvoices();
    } catch (error) {
      console.error('Error adding invoice:', error);
    }
  };


  const updateInvoice = async (invoiceData) => {
    try {
      const response = await fetch(`${service}/invoice/${invoiceData.id}`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(invoiceData),
      });
      const updatedInvoice = await response.json();
      const updatedInvoices = invoices.map((invoice) =>
        invoice.id === updatedInvoice.id ? updatedInvoice : invoice
      );
      setInvoices(updatedInvoices);
      setSelectedInvoice(null);
    } catch (error) {
      console.error('Error updating invoice:', error);
    }
  };


  const deleteInvoice = async (invoiceId) => {
    try {
      await fetch(`${service}/invoice/${invoiceId}`, {
        method: 'DELETE',
      });
      const updatedInvoices = invoices.filter((invoice) => invoice.id !== invoiceId);
      setInvoices(updatedInvoices);
    } catch (error) {
      console.error('Error deleting invoice:', error);
    }
  };

  const fetchDetails = async (invoiceId) => {
    try {
      const response = await fetch(`${service}/invoice/detail?invoiceId=${invoiceId}`);
      const data = await response.json();
      setDetails(data);
    } catch (error) {
      console.error('Error fetching invoices:', error);
    }
  };
  
  const addDetail = async (detailData) => {
    try {
      const response = await fetch(`${service}/invoice/detail`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(detailData),
      });
      fetchDetails(detailData.invoiceId);
    } catch (error) {
      console.error('Error adding detail:', error);
    }
  };

  const deleteDetail = async (detailId) => {
    try {
      await fetch(`${service}/invoice/detail/${detailId}`, {
        method: 'DELETE',
      });
      const updatedDetails = details.filter((detail) => detail.id !== detailId);
      setDetails(updatedDetails);
    } catch (error) {
      console.error('Error deleting detail:', error);
    }
  };

  return (
    <div>
      <h1>Invoice Application</h1>
      <InputForm addInvoice={addInvoice} updateInvoice={updateInvoice} initialData={{ id: '', client: '', taxId: 'CF', total: 0 }} />
      <InvoiceList invoices={invoices} handleShow={handleShow} editInvoice={setSelectedInvoice} deleteInvoice={deleteInvoice} />
      {selectedInvoice ? (
        <InvoiceEdit invoice={selectedInvoice} updateInvoice={updateInvoice} show={show} handleClose={handleClose} addDetail={addDetail} details={details} deleteDetail={deleteDetail}/>
      ) : null}
    </div>
  );
}

export default App;