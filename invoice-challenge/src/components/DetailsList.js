import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import ButtonGroup from 'react-bootstrap/ButtonGroup';

const DetailsList = ({ details, deleteDetail }) => {

  return (
    <div>
        <Table striped bordered hover>
            <thead>
                <tr>
                    <th>Producto</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
            {details.map((detail) => (
                <tr key={detail.id}>
                    <td>{detail.product}</td>
                    <td>{detail.price}</td>
                    <td>{detail.quantity}</td>
                    <td>{detail.price * detail.quantity}</td>
                    <td>
                    <ButtonGroup aria-label="acciones">
                        <Button variant="danger" onClick={() => deleteDetail(detail.id)}>Borrar</Button>
                    </ButtonGroup>
                    </td>
                </tr>
                ))}
            </tbody>
        </Table>
    </div>
  );
};

export default DetailsList;