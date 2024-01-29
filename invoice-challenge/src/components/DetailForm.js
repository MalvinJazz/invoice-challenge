import React, { useState } from 'react';
import FloatingLabel from 'react-bootstrap/FloatingLabel';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

const DetailForm = ({ addDetail, initialData }) => {
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
    addDetail(formData);
    setFormData(initialData);
  };

  return (
    <Form>
      <FloatingLabel
        controlId="product"
        label="Product"
        className="mb-3"
      >
        <Form.Control type="text" placeholder="Leche" name="product" value={formData.product} onChange={handleInputChange} />
      </FloatingLabel>
      <FloatingLabel controlId="quantity" label="Cantidad">
        <Form.Control type="number" value={formData.quantity} name="quantity" onChange={handleInputChange} />
      </FloatingLabel>
      <FloatingLabel controlId="price" label="precio">
        <Form.Control type="number" value={formData.price} name="price" onChange={handleInputChange} />
      </FloatingLabel>
      <Button variant="primary" type="button" onClick={handleSubmit}>Guardar</Button>
    </Form>
  );
};

export default DetailForm;