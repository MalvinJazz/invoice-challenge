import React, { useState } from 'react';
import FloatingLabel from 'react-bootstrap/FloatingLabel';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

const InputForm = ({ addInvoice, updateInvoice, initialData }) => {
  const [formData, setFormData] = useState(initialData);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    if (formData.id) {
      updateInvoice(formData);
    } else {
      addInvoice(formData);
    }
    setFormData({ id: '', client: '', taxId: 'CF', total: 0 });
  };

  return (
    <Form onSubmit={handleSubmit}>
      <FloatingLabel
        controlId="client"
        label="Nombre del Cliente"
        className="mb-3"
      >
        <Form.Control type="text" placeholder="cliente" name="client" value={formData.client} onChange={handleInputChange} />
      </FloatingLabel>
      <FloatingLabel controlId="taxId" label="NIT">
        <Form.Control type="text" placeholder="CF" value={formData.taxId} onChange={handleInputChange} />
      </FloatingLabel>
      <Button variant="primary" type="submit">Guardar</Button>
    </Form>
  );
};

export default InputForm;