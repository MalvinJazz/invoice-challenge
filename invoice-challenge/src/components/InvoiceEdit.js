import React, { useState, useEffect } from 'react';
import InputForm from './InputForm';
import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import DetailForm from './DetailForm';
import DetailsList from './DetailsList';

const InvoiceEdit = ({ invoice, updateInvoice, show, handleClose, addDetail, deleteDetail, details}) => {

    return (
        <div
        className="modal show"
        style={{ display: 'block', position: 'initial' }}
        >
        <Modal show={show} onHide={handleClose}>
            <Modal.Header closeButton>
            <Modal.Title>Editar Factura</Modal.Title>
            </Modal.Header>

            <Modal.Body>
                <InputForm initialData={invoice} updateInvoice={updateInvoice} />
                <br/>
                <DetailForm addDetail={addDetail} initialData={{ id: 0, product: '', quantity: 0, price: 0, invoiceId: invoice.id }} />
                <br/>
                <DetailsList details={details} deleteDetail={deleteDetail}/>
                <h4>Total: {invoice.total}</h4>
            </Modal.Body>

            <Modal.Footer>
                <Button variant="secondary" onClick={handleClose}>Cerrar</Button>
            </Modal.Footer>
        </Modal>
        </div>
    );
    };

export default InvoiceEdit;