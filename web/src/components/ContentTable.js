import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TablePagination from '@material-ui/core/TablePagination';
import TableRow from '@material-ui/core/TableRow';
import Data from '../data';
import Button from "@material-ui/core/Button";
import Collapse from "@material-ui/core/Collapse";
import Typography from "@material-ui/core/Typography";

var obj = JSON.stringify({data:[
    {
        "name":"7Springeren",
        "venteliste":23,
        "homepage":"http://amagerhus.kbhbarn.kk.dk/FrontEnd.aspx?id=19484622",
        "periodiskTilsyn":
            {
                "foerste":
                    {
                        "InklussionOgFællesskab":
                            {
                                "indsats":"Tilpasning Af Indsats",
                                "begrundelse":"ASLKdnas Asmdælamsldmwqa asældmasæmdæasm asdmasælmælamsdæm sadmaælsmdæasmdæ saædmælasmdælas",
                                "anbefaling":"Dette er anbefalingen"
                            }
                        ,
                        "SocialeRelationer":
                            {
                                "indsats":"Tilpasning Af Indsats",
                                "begrundelse":"ASLKdnas Asmdælamsldmwqa asældmasæmdæasm asdmasælmælamsdæm sadmaælsmdæasmdæ saædmælasmdælas",
                                "anbefaling":"Dette er anbefalingen"
                            },
                        "Sprogindsatsen":
                            {
                                "indsats":"Tilpasning Af Indsats",
                                "begrundelse":"ASLKdnas Asmdælamsldmwqa asældmasæmdæasm asdmasælmælamsdæm sadmaælsmdæasmdæ saædmælasmdælas",
                                "anbefaling":"Dette er anbefalingen"
                            }
                        ,
                        "Forældresamarbejde":
                            {
                                "indsats":"Tilpasning Af Indsats",
                                "begrundelse":"ASLKdnas Asmdælamsldmwqa asældmasæmdæasm asdmasælmælamsdæm sadmaælsmdæasmdæ saædmælasmdælas",
                                "anbefaling":"Dette er anbefalingen"
                            }
                        ,
                        "SammenhængOgOvergange":
                            {
                                "indsats":"Tilpasning Af Indsats",
                                "begrundelse":"ASLKdnas Asmdælamsldmwqa asældmasæmdæasm asdmasælmælamsdæm sadmaælsmdæasmdæ saædmælasmdælas",
                                "anbefaling":"Dette er anbefalingen"
                            }
                        ,
                        "KravOmReflektion":
                            {
                                "indsats":"vedligeholdelse Af Indsats",
                                "begrundelse":"ASLKdnas Asmdælamsldmwqa asældmasæmdæasm asdmasælmælamsdæm sadmaælsmdæasmdæ saædmælasmdælas",
                                "anbefaling":"Dette er anbefalingen"
                            }

                    }

            }

    },
    {
        "name":"Klaphatten",
        "venteliste":23,
        "homepage":"http://amagerhus.kbhbarn.kk.dk/FrontEnd.aspx?id=19484622",
        "periodiskTilsyn":
            {
                "foerste":
                    {
                        "InklussionOgFællesskab":
                            {
                                "indsats":"Tilpasning Af Indsats",
                                "begrundelse":"ASLKdnas Asmdælamsldmwqa asældmasæmdæasm asdmasælmælamsdæm sadmaælsmdæasmdæ saædmælasmdælas",
                                "anbefaling":"Dette er anbefalingen"
                            }
                        ,
                        "SocialeRelationer":
                            {
                                "indsats":"Tilpasning Af Indsats",
                                "begrundelse":"ASLKdnas Asmdælamsldmwqa asældmasæmdæasm asdmasælmælamsdæm sadmaælsmdæasmdæ saædmælasmdælas",
                                "anbefaling":"Dette er anbefalingen"
                            }
                        ,
                        "Sprogindsatsen":
                            {
                                "indsats":"Tilpasning Af Indsats",
                                "begrundelse":"ASLKdnas Asmdælamsldmwqa asældmasæmdæasm asdmasælmælamsdæm sadmaælsmdæasmdæ saædmælasmdælas",
                                "anbefaling":"Dette er anbefalingen"
                            }
                        ,
                        "Forældresamarbejde":
                            {
                                "indsats":"Tilpasning Af Indsats",
                                "begrundelse":"ASLKdnas Asmdælamsldmwqa asældmasæmdæasm asdmasælmælamsdæm sadmaælsmdæasmdæ saædmælasmdælas",
                                "anbefaling":"Dette er anbefalingen"
                            }
                        ,
                        "SammenhængOgOvergange":
                            {
                                "indsats":"Tilpasning Af Indsats",
                                "begrundelse":"ASLKdnas Asmdælamsldmwqa asældmasæmdæasm asdmasælmælamsdæm sadmaælsmdæasmdæ saædmælasmdælas",
                                "anbefaling":"Dette er anbefalingen"
                            }
                        ,
                        "KravOmReflektion":
                            {
                                "indsats":"vedligeholdelse Af Indsats",
                                "begrundelse":"ASLKdnas Asmdælamsldmwqa asældmasæmdæasm asdmasælmælamsdæm sadmaælsmdæasmdæ saædmælasmdælas",
                                "anbefaling":"Dette er anbefalingen"
                            }

                    }

            }

    }
]
});

const jsonObject = JSON.parse(obj);



const columns = [
    { id: 'name', label: 'Name', minWidth: 170 },
    { id: 'venteliste', label: 'venteliste', minWidth: 100 },
    {
        id: 'homepage',
        label: 'homepage',
        minWidth: 170,
        align: 'right',
        format: (value) => value.toLocaleString('en-US'),
    },
    {
        id: 'InklussionOgFællesskab',
        label: 'InklussionOgFællesskab',
        minWidth: 170,
        align: 'right',
        format: (value) => value.toLocaleString('en-US'),
    },
    {
        id: 'SocialeRelationer',
        label: 'SocialeRelationer',
        minWidth: 170,
        align: 'right',
        format: (value) => value.toLocaleString('en-US'),
    },
    {
        id: 'Forældresamarbejde',
        label: 'Forældresamarbejde',
        minWidth: 170,
        align: 'right',
        format: (value) => value.toLocaleString('en-US'),
    },
    {
        id: 'SammenhængOgOvergange',
        label: 'SammenhængOgOvergange',
        minWidth: 170,
        align: 'right',
        format: (value) => value.toLocaleString('en-US'),
    },
    {
        id: 'KravOmReflektion',
        label: 'KravOmReflektion',
        minWidth: 170,
        align: 'right',
        format: (value) => value.toLocaleString('en-US'),
    },
];

function createData(name, venteliste, homepage, InklussionOgFællesskab,SocialeRelationer,Forældresamarbejde,SammenhængOgOvergange,KravOmReflektion) {
    return { name, venteliste, homepage, InklussionOgFællesskab,SocialeRelationer,Forældresamarbejde,SammenhængOgOvergange,KravOmReflektion};
}

function createDataArray(jsonObject){
    const rowsh = [];
    for (var i = 0; i < jsonObject.data.length; i++) {
        var obj = jsonObject.data[i];

        console.log(obj.name);
        var data = createData(obj.name, obj.venteliste, obj.homepage,
            obj.periodiskTilsyn.foerste.InklussionOgFællesskab.indsats,
            obj.periodiskTilsyn.foerste.Forældresamarbejde.indsats,
            obj.periodiskTilsyn.foerste.KravOmReflektion.indsats,
            obj.periodiskTilsyn.foerste.SocialeRelationer.indsats,
            obj.periodiskTilsyn.foerste.Sprogindsatsen.indsats);

        rowsh.push(data);
    }
    return rowsh;
}

const rows = createDataArray(jsonObject);


const useStyles = makeStyles({
    root: {
        width: '100%',
    },
    container: {
        maxHeight: '100%',
    },
});

export const testFunction = () => {
    return (
        <TableCell>sdasdasd</TableCell>
    )
};

function handleEventFolder(){
    testFunction();

}


export default function StickyHeadTable() {
    const classes = useStyles();
    const [page, setPage] = React.useState(0);
    const [rowsPerPage, setRowsPerPage] = React.useState(100);

    const handleChangePage = (event, newPage) => {
        setPage(newPage);
    };

    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(+event.target.value);
        setPage(0);
    };

    return (
        <Paper className={classes.root}>
            <TableContainer className={classes.container}>
                <Table stickyHeader aria-label="sticky table">
                    <TableHead>
                        <TableRow>
                            {columns.map((column) => (
                                <TableCell
                                    key={column.id}
                                    align={column.align}
                                    style={{ minWidth: column.minWidth }}
                                >
                                    {column.label}
                                </TableCell>
                            ))}
                        </TableRow>
                    </TableHead>
                   <TableBody>
                        {rows.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage).map((row) => {
                            return (
                                <TableRow hover role="checkbox" tabIndex={-1} key={row.name}>
                                    {columns.map((column) => {
                                        const value = row[column.id];
                                        return (
                                            <TableCell key={column.id} align={column.align}>
                                                <div>
                                                    {column.id==="InklussionOgFællesskab"
                                                    || column.id==="SocialeRelationer"
                                                    ||column.id==="Forældresamarbejde" ||
                                                    column.id==="SammenhængOgOvergange" ||
                                                    column.id==="KravOmReflektion" ?<Button onClick={handleEventFolder}>{value}</Button>:column.format && typeof value === 'number' ? column.format(value) : value}
                                                </div>

                                            </TableCell>
                                        );
                                    })}
                                </TableRow>
                            );
                        })}
                    </TableBody>
                </Table>
            </TableContainer>
            <TablePagination
                rowsPerPageOptions={[100, 25, 100]}
                component="div"
                count={rows.length}
                rowsPerPage={rowsPerPage}
                page={page}
                onChangePage={handleChangePage}
                onChangeRowsPerPage={handleChangeRowsPerPage}
            />
        </Paper>
    );
}
