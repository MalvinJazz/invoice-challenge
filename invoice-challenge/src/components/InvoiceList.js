import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import ButtonGroup from 'react-bootstrap/ButtonGroup';

const InvoiceList = ({ invoices, handleShow, editInvoice, deleteInvoice }) => {

  return (
    <div>
        <h2>Lista de Facturas</h2>
        <Table striped bordered hover>
            <thead>
                <tr>
                    <th>#</th>
                    <th>Cliente</th>
                    <th>Total</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
            {invoices.map((invoice) => (
                <tr key={invoice.id}>
                    <td>{invoice.id}</td>
                    <td>{invoice.client}</td>
                    <td>{invoice.total}</td>
                    <td>
                    <ButtonGroup aria-label="acciones">
                        <Button variant="secondary" onClick={() => {editInvoice(invoice); handleShow();}}>Editar</Button>
                        <Button variant="danger" onClick={() => deleteInvoice(invoice.id)}>Borrar</Button>
                    </ButtonGroup>
                    </td>
                </tr>
                ))}
            </tbody>
        </Table>
    </div>
  );
};

export default InvoiceList;